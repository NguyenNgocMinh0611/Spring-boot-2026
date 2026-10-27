package com.springmasterclass.study.bai5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "checkups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Checkup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnosis;

    // bắt buộc là LAZY để tái hiện N+1
    // khi đánh dấu LAZY thì Hibernate sẽ không thực thi các câu lệnh Join để lấy các dữ liệu liên kết ngay lập tức
    // thay vào đó sẽ sử dụng kỹ thuật Hibernate Proxy
    // tại lần truy vấn đầu tiên: Hibernate chỉ lấy dữ liệu của thực thể chính. Đối với thực thể liên kết (đầu N),
        // Hibernate sẽ gán một "đối tượng giả" (Proxy) vào đó.

    // Khi gọi Getter: Chỉ khi gọi hàm getCheckups() (ví dụ trong bài trc), Proxy này mới "thức tỉnh" và kích hoạt
        // một câu lệnh SQL thứ hai để nạp dữ liệu thực tế từ Database vào.

    @ManyToOne(fetch = FetchType.LAZY) // đầu N
    // Annotation này sẽ xác định đâu là chủ sở hữu
    // @ManyToOne là chủ sở hữu
    // Ví dụ ở đây  là Checkup là chủ sở hữu của mối quan hệ
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
