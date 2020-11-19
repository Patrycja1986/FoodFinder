package com.foodFinder.service.order;

import com.foodFinder.exceptions.MealsFromDifferentRestaurantsException;
import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.order.Order;
import com.foodFinder.model.order.OrderDTO;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.repository.CustomerRepository;
import com.foodFinder.repository.OrderRepository;
import com.foodFinder.repository.RestaurantRepository;
import com.foodFinder.service.email.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @Override
    public void save(OrderDTO orderDTO) throws ParseException {
        Order order = convertToEntity(orderDTO);
        orderRepository.save(order);
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<Order> byId = orderRepository.findById(id);
        if (byId.isPresent()) {
            Set<OrderedMeal> orderedMeals = byId.get().getOrderedMeals();
            orderedMeals.stream().map(orderedMeal -> orderedMeal.getMeal().getRestaurant().getId()).collect(Collectors.toSet());
            if (orderedMeals.size() != 1) {
                throw new MealsFromDifferentRestaurantsException();
            }
            return byId
                    .map(this::convertToDto)
                    .orElseThrow(RuntimeException::new);
        } else {
            throw new ObjectNotFoundException("Order by id= " + id + " not found");
        }
    }

    @Override
    public Set<OrderDTO> findAll() {
        Set<Order> set = new HashSet<>();
        orderRepository.findAll().iterator().forEachRemaining(set::add);
        return set.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @Override
    public Set<OrderDTO> findByRestaurantId(Long id) {
        Set<Order> byRestaurantId = orderRepository.findByRestaurantId(id);
        if (byRestaurantId.size() != 0) {
            return byRestaurantId.stream().map(this::convertToDto).collect(Collectors.toSet());
        } else {
            throw new ObjectNotFoundException("No orders found for Restaurant by id= " + id + ". Check if Restaurant exists.");
        }
    }

    @Override
    public Set<OrderDTO> findByCustomerId(Long id) {
        Set<Order> byCustomerId = orderRepository.findByCustomerId(id);
        if (byCustomerId.size() != 0) {
            return byCustomerId.stream().map(this::convertToDto).collect(Collectors.toSet());
        } else {
            throw new ObjectNotFoundException("No orders found for Customer by id= " + id + ". Check if Customer exists.");
        }
    }

    @Override
    public void delete(Long id) {
        Order order = orderRepository.findById(id)
                .orElse(new Order());
        orderRepository.delete(order);
    }

    @Override
    public void save(Long customerId, Long restaurantId) {
        Optional<Customer> customerById = customerRepository.findById(customerId);
        Optional<Restaurant> restaurantById = restaurantRepository.findById(restaurantId);

        if(customerById.isPresent()){
            if(restaurantById.isPresent()){
                Order order= new Order(customerById.get(), restaurantById.get());
                orderRepository.save(order);
            }else{
                throw new ObjectNotFoundException("Restaurant by id= "+restaurantId+ " not found");
            }
        }else{
            throw new ObjectNotFoundException("Customer by id= "+customerId+ " not found");
        }
    }

    @Override
    public void save(Long customerId) throws IOException {
        Optional<Customer> customerById = customerRepository.findById(customerId);

        if (customerById.isPresent()){
            String customerEmail = customerById.get().getCustomerEmail();
            Order order=new Order();
            order.setCustomer(customerById.get());
            orderRepository.save(order);
            emailService.sendText("patrycja.guz1986@gmail.com",customerEmail,"Confirmation","Confirmation");

        }else{
            throw new ObjectNotFoundException("Customer by id= "+customerId+ " not found");
        }

    }

    private OrderDTO convertToDto(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    private Order convertToEntity(OrderDTO orderDTO) throws ParseException {
        return modelMapper.map(orderDTO, Order.class);
    }

}
