# ĐỒ ÁN MÔN HƯỚNG ĐỐI TƯỢNG-JAVA

_Người thực hiện: Nguyễn Hữu Phước_
_MSSV: N19DCCN145_

## Mô tả
Chương trình quản lý thư viện đơn giản, gồm các chức năng:
    * Hỗ trợ làm thẻ thư viện và quản lý thông tin người đọc
    * Thực hiện thủ tục mượn trả sách
    * Cập nhật sách mới
    * Hỗ trợ người đọc tra cứu sách
    * Cho biết đầu sách người đọc đang mượn và hạn trả
## Build và chạy chương trình

## Cấu trúc thư mục
    ./data chứa các file .txt phục vụ cho việc lưu trữ dữ liệu trong quá trình sử dụng. ** CHỈNH SỬA FILE NÀY CÓ THỂ GÂY RA LỖI ** cân nhắc kỹ trước khi thay đổi.
    ./src chứa source code chương trình

    Ứng dụng phát triển dựa trên mô hình MVC swing, component chia làm 3 thành phần Model, View, Controller.
    Model thiết lập các thuộc tính, phương thức khởi tạo
    Controller dựa trên Model cung cấp các hàm tương tác với Model, đồng thời đảm nhiệm vai trò lưu, tải dữ liệu
    View cung cấp cho người dùng giao diện để tương tác với phần mềm.
    
    Với mô hình MVC việc chia nhỏ các thành phân của phần mềm giúp cho việc phát triển, bảo trì, nâng cấp dễ dàng hơn.

    Các tính năng
    BOOK: add, adjust, find
    READER: add, adjust, find
    BORROW and RETURN


## Cấu trúc file data
 reader.txt: Dòng đầu tiên của file thể hiện số lượng độc giả hiện tại
            Cứ 3 Dòng tiếp theo thể hiện cho 1 độc giả, tương ứng mã, tên, ngày tạo của độc giả.

book.txt: Dòng đầu tiên của file lưu số lượng sách hiện tại
        các dòng tiếp theo lưu thông tin của 1 sách theo thứ tự: ID, tên, thể loại, vịa trí (số tủ, số kệ), số lượng nhập, số lượng có sẵn.

borrowdata.txt: lưu trữ dữ liệu mượn trả, cấu trúc từng dòng theo thưs tự: ID người mượn, ID sách mượn, ngày mượn, trạng thái đã trả hay chưa