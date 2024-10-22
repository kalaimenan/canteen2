package com.rome.canteen.service;

import com.rome.canteen.model.Order;
import com.rome.canteen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TimeSlotService timeSlotService;

    // Method to place a new order (Create)
    public String placeOrder(Order order) {
        if (!timeSlotService.isTimeSlotAvailable(order.getCategory(), order.getTimeSlot())) {
            return "Time slot is full. Please choose another time slot.";
        }
        timeSlotService.incrementTimeSlotOrder(order.getCategory(), order.getTimeSlot());
        orderRepository.save(order);
        return "Order placed successfully!";
    }

    // Retrieve all orders (Read)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Retrieve a single order by ID (Read)
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    // Update an existing order (Update)
    public String updateOrder(String id, Order updatedOrder) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();
            existingOrder.setCategory(updatedOrder.getCategory());
            existingOrder.setTimeSlot(updatedOrder.getTimeSlot());
            existingOrder.setUserId(updatedOrder.getUserId());
            existingOrder.setFoodItemId(updatedOrder.getFoodItemId());
            orderRepository.save(existingOrder);
            return "Order updated successfully!";
        } else {
            return "Order not found.";
        }
    }

    // Delete an order by ID (Delete)
    public String deleteOrder(String id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return "Order deleted successfully!";
        } else {
            return "Order not found.";
        }
    }
}
