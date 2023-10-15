# HỆ THỐNG HỖ TRỢ HƯỚNG NGHIỆP CHO HỌC SINH
Trong thời đại ngày nay, có rất nhiều ngành nghề ở nhiều lĩnh vực khác nhau, như các lĩnh vực về kinh tế, kỹ thuật, công nghệ thông tin,… Tuy vậy, cũng có đa số mọi người, đặc biệt là các bạn học sinh đang học ở các trường trung học phổ thông vẫn còn mơ hồ trong việc chọn ngành nghề phù hợp với bản thân trong tương lai hoặc chưa xác định rõ được bản thân đam mê những gì để có thể theo đuổi.

Để đáp ứng các yêu cầu trên, đề tài **"Phát triển hệ thống hướng nghiệp cho học sinh"** được đề xuất. Mục tiêu của đề tài này là xây dựng một hệ thống cho phép làm bài khảo sát, đánh giá mức độ phù hợp với các nhóm ngành nghề trên cơ sở lý thuyết “Bộ câu hỏi trắc nghiệm nghề nghiệp” của tiến sĩ tâm lý học người Mỹ - John L.Holland. Từ kết quả khảo sát có được, sẽ đưa ra thang điểm đánh giá mức độ phù hợp với từng nhóm lĩnh vực và các gợi ý về ngành nghề phù hợp.

## Các chức năng của hệ thống
### Chức năng phía người dùng
* Đăng nhập/đăng ký.
* Làm bài khảo sát Holland.
* Xem lại lịch sử, kết quả khảo sát đã thực hiện.

### Chức năng phía quản trị viên
* CRUD người dùng.
* CRUD khảo sát.
* CRUD câu hỏi.
* CRUD phương án.
* Thống kê số lượng người dùng, số lượt làm khảo sát.

## Hướng dẫn cài đặt
#### Bước 1: Yêu cầu môi trường cài đặt (vui lòng bỏ qua nếu đã đáp ứng các môi trường bên dưới).
* **Cài đặt môi trường NodeJS:** vào [trang chủ của NodeJS](https://nodejs.org) và tải về phiên bản `18.18.2 LTS` (tính đến ngày 15/10/2023). Sau đó mở tập tin cài đặt đã tải và làm theo hướng dẫn.
* **Cài đặt JDK 17:** tải và cài đặt JDK 17 [tại đây](https://download.oracle.com/java/17/archive/jdk-17.0.8_windows-x64_bin.exe (sha256 )). Sau đó mở tập tin cài đặt đã tải và làm theo hướng dẫn.
* **Cài đặt MySQL Community Server:** tải và cài đặt MySQL Community Server [tại đây](https://dev.mysql.com/get/Downloads/MySQL-8.1/mysql-8.1.0-winx64.msi). Sau đó mở tập tin cài đặt đã tải và làm theo hướng dẫn.
* **Cài đặt MySQL Workbench:** tải và cài đặt MySQL Workbench [tại đây](https://dev.mysql.com/get/Downloads/MySQLGUITools/mysql-workbench-community-8.0.34-winx64.msi). Sau đó mở tập tin cài đặt đã tải và làm theo hướng dẫn.
* **Cài đặt Visual Studio Code:** vào [trang chủ của Visual Studio Code](https://code.visualstudio.com/download) và tải phiên bản phù hợp với máy tính.
* **Cài đặt IntelliJ IDEA Community:** vào [trang chủ của JetBrains](https://www.jetbrains.com/idea/download/?section=windows) và tải phiên bản IntelliJ IDEA Commnunity.
  
#### Bước 2: Mở `command line` hoặc `git bash` và gõ lệnh sau để tải mã nguồn đồ án về máy tính.
```
git clone https://github.com/workanhnguyen/major_project
```
#### Bước 3: Mở thư mục `client` bằng **Visual Studio Code** và mở thư mục `server` bằng **IntelliJ IDEA Community**.

#### Bước 4: Mở **MySQL Workbench** và tạo mới một schema đặt tên là `major_project_db`. Sau đó nhập dữ liệu từ tập tin `major_project_db.sql`.

#### Bước 5: Với thư mục `server` đã mở với **IntelliJ IDEA Community**, mở tập tin `application.properties` và sửa lại các lệnh sau:
```
spring.datasource.username=<Tên đăng nhập MySQL>
spring.datasource.password=<Mật khẩu đăng nhập MySQL>
```
Sau khi chỉnh sửa, mở tập tin `ServerApplication.java` và chạy tập tin này. Ứng dụng Java sẽ được chạy trên `http://localhost:8085/server`.

#### Bước 6: Với thư mục `client` đã mở với **Visual Studio Code**, mở terminal và thực thi lần lượt các lệnh sau:
```
npm install yarn
```
Sau khi thực thi thành công lệnh trên, thực thi tiếp lệnh sau để cài đặt tất cả các package cần thiết cho ứng dụng `ReactJS`:
```
yarn install
```
Cuối cùng thực thi lệnh sau để chạy ứng dụng:
```
yarn dev
```
Ứng dụng sẽ chạy trên `http://localhost:5173`.

## Hướng dẫn sử dụng
Người dùng truy cập vào `http://localhost:5173` và đăng nhập bằng tài khoản sẵn có hoặc đăng ký tài khoản mới. 
* **Lưu ý: Khi đăng ký, hệ thống sẽ gửi một email xác nhận tài khoản theo email đã đăng ký trên hệ thống, để xác nhận được tài khoản, vui lòng mở Gmail trên cùng một máy tính.**.
* Hoặc có thể sử dụng tài khoản thử nghiệm sau:
```
Tên tài khoản: test
Mật khẩu: 12345aA@
```
* Khi đăng nhập thành công, người dùng có thể sử dụng các chức năng của hệ thống.

Đối với quản trị viên, truy cập vào `http://localhost:8085/server` và sử dụng tài khoản sau để đăng nhập với vai trò admin:
```
Tên tài khoản: admin@gmail.com
Mật khẩu: 1234
```
* Sau khi đăng nhập thành công, quản trị viên có thể sử dụng các chức năng quản trị.
