// Gọi API từ một URL và xử lý dữ liệu trả về
fetch('http://localhost:8080/api/pet') // Thay thế URL này bằng API thật
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Chuyển đổi dữ liệu trả về thành JSON
    })
    .then(data => {
        console.log(data); // Xử lý dữ liệu nhận được
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });