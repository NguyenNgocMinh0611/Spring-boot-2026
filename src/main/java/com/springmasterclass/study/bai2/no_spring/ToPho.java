package com.springmasterclass.study.bai2.no_spring;

public class ToPho {
    private BanhPho banhPho;
    private ThitBo thitBo;

    public ToPho(BanhPho banhPho, ThitBo thitBo) {
        // Vấn đề: Tightly Couple là bị trói chặt vào nhau. Cực kỳ khó bảo trì code
        // giải quyết vấn đề này Spring sẽ sử dụng IoC (Inversion of Control - đảo ngược điều khiển)
        // giao toàn quyền cho một ông chủ nhà hoặc chủ nhà hàng
        // => này gọi là Spring Container (quản lý Bean)
        // giờ muốn nó giao nguyên liệu để làm tô phở thì nó sẽ dùng DI (Dependency Injection thêm phụ thuộc)
        this.banhPho = banhPho;
        this.thitBo = thitBo;
    }

    public void phucVu(){
        System.out.println("phuc vu to pho gom: " + banhPho.layBanhPho() + " va " + thitBo.layThitBo());
    }
}
