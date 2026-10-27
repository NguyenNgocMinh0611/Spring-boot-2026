package com.springmasterclass.study.bai5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity // đánh dấu là 1 JPA Entity
@Table(name = "patients") // Ánh xạ với bảng patients trong DB
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient { // Đầu 1
    @Id // khai báo Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullName", nullable = false, length = 100)
    private String fullName;

    @Column(unique = true, length = 12)
    private String citizenId; // cccd

    private LocalDateTime createAt;

    // nếu quên mappedBy thì Hibernate sẽ tự tạo bảng thứ 3 là một cái Join Table và có tên là PatientCheckup
    // như vậy sẽ bị dư thừa và sai chuẩn CSDL Quan hệ
    // cascade = CascadeType.ALL : Khái niệm này gọi là Hiệu ứng dây chuyền. Khi bạn lưu (persist) một bệnh nhân
        // mới kèm theo 3 lượt khám, bạn không cần gọi hàm save() 4 lần. Bạn chỉ cần patientRepository.save(patient),
        // Hibernate sẽ tự động đẩy lệnh INSERT cho cả 3 lượt khám kia.
    // orphanRemoval = true : Nếu xóa một lượt khám ra khỏi danh sách checkups của Bệnh nhân (bằng hàm remove()),
        // Hibernate sẽ tự động sinh lệnh DELETE lượt khám đó dưới Database. Nó sẽ ngăn chặn việc tồn tại những dữ liệu
        // "mồ côi" (orphan) không thuộc về ai.
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Checkup> checkups;
}
