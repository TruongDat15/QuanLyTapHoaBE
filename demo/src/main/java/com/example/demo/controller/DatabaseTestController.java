package com.example.demo.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@RestController
@RequestMapping("/api/connection-test")
public class DatabaseTestController {

    private final UserRepo userRepository;

    // Sử dụng Dependency Injection (Constructor Injection được khuyên dùng)
    public DatabaseTestController(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * API Test: Lấy tất cả người dùng từ database
     */
    @GetMapping("/users")
    public ResponseEntity<?> testDatabaseConnection() {
        try {
            // Thực hiện truy vấn DB
            List<User> users = userRepository.findAll();
            
            if (users.isEmpty()) {
                return ResponseEntity.ok("Kết nối database thành công, nhưng hiện không có user nào trong bảng Users.");
            }
            
            // Trả về danh sách user nếu có
            return ResponseEntity.ok(users);
            
        } catch (Exception e) {
            // Nếu có lỗi, in ra console và trả về lỗi 500
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("LỖI KẾT NỐI DB: Kiểm tra application.properties và XAMPP đã chạy chưa.");
        }
    }
}