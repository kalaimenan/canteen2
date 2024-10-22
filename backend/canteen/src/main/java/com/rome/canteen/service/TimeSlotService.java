package com.rome.canteen.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TimeSlotService {

    // This map will store the count of orders for each time slot in each category
    private Map<String, Map<String, Integer>> timeSlotOrders = new HashMap<>();

    public TimeSlotService() {
        initializeTimeSlots();
    }

    // Initialize time slots for breakfast, lunch, and dinner
    private void initializeTimeSlots() {
        timeSlotOrders.put("breakfast", createTimeSlots(new String[]{
                "7:00 AM - 7:30 AM", "7:30 AM - 8:00 AM", "8:00 AM - 8:30 AM", "8:30 AM - 9:00 AM",
                "9:00 AM - 9:30 AM", "9:30 AM - 10:00 AM", "10:00 AM - 10:30 AM", "10:30 AM - 11:00 AM"
        }));

        timeSlotOrders.put("lunch", createTimeSlots(new String[]{
                "12:00 PM - 12:30 PM", "12:30 PM - 1:00 PM", "1:00 PM - 1:30 PM", "1:30 PM - 2:00 PM",
                "2:00 PM - 2:30 PM", "2:30 PM - 3:00 PM", "3:00 PM - 3:30 PM", "3:30 PM - 4:00 PM",
                "4:00 PM - 4:30 PM", "4:30 PM - 5:00 PM"
        }));

        timeSlotOrders.put("dinner", createTimeSlots(new String[]{
                "6:00 PM - 6:30 PM", "6:30 PM - 7:00 PM", "7:00 PM - 7:30 PM"
        }));
    }

    // Create time slots with an initial order count of 0
    private Map<String, Integer> createTimeSlots(String[] timeSlots) {
        Map<String, Integer> slots = new HashMap<>();
        for (String timeSlot : timeSlots) {
            slots.put(timeSlot, 0);
        }
        return slots;
    }

    // Check if a time slot has availability (less than 5 orders)
    public boolean isTimeSlotAvailable(String category, String timeSlot) {
        return timeSlotOrders.get(category).get(timeSlot) < 5;
    }

    // Increment the order count for the given time slot
    public void incrementTimeSlotOrder(String category, String timeSlot) {
        timeSlotOrders.get(category).put(timeSlot, timeSlotOrders.get(category).get(timeSlot) + 1);
    }
}

