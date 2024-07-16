                     
<h1 align="center" style="font-weight: bold;">JavaNinjas💻</h1>

<p align="center">
<a href="#tech">Technologies</a>
<a href="#started">Getting Started</a>
<a href="#routes">API Endpoints</a>
<a href="#colab">Collaborators</a>
<a href="#contribute">Contribute</a> 
</p>


<p align="center">Dự án JavaNinJas làm về đề tài trang bán đồ cho Làng Lá</p>


<p align="center">
<a href="https://github.com/PhamNhatHoang/DATN_Fpoly">📱 Tham khảo trang</a>
</p>
 
<h2 id="technologies">💻 Công nghệ sử dụng</h2>

AngularJS, Thymeleaf, Spring Boot, API Payment
 
<h2 id="started">🚀 Bắt đầu!</h2>

Để chạy được dự án này bạn cần làm các bước sau
 
<h3>Prerequisites</h3>

Here you list all prerequisites necessary for running your project. For example:

- [NodeJS](https://github.com/)
- [Git 2](https://github.com)
 
<h3>Cloning</h3>

Cách để clone dự án về máy:

```bash
git clone https://github.com/PhamNhatHoang/DATN_Fpoly.git
```
 
<h3>Config .env variables</h2>

Use the `.env.example` as reference to create your configuration file `.env` with your AWS Credentials

```yaml
NODE_AWS_REGION=us-east-1
NODE_AWS_KEY_ID={YOUR_AWS_KEY_ID}
NODE_AWS_SECRET={YOUR_AWS_SECRET}
```
 
<h3>Bắt đầu</h3>

How to start your project

```bash
cd project-name
npm some-command-to-run
```
 
<h2 id="routes">📍 API Endpoints</h2>

Here you can list the main routes of your API, and what are their expected request bodies.
​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /authenticate</kbd>     | retrieves user info see [response details](#get-auth-detail)
| <kbd>POST /authenticate</kbd>     | authenticate user into the api see [request details](#post-auth-detail)

<h3 id="get-auth-detail">GET /authenticate</h3>

**RESPONSE**
```json
{
  "name": "Fernanda Kipper",
  "age": 20,
  "email": "her-email@gmail.com"
}
```

<h3 id="post-auth-detail">POST /authenticate</h3>

**REQUEST**
```json
{
  "username": "fernandakipper",
  "password": "4444444"
}
```

**RESPONSE**
```json
{
  "token": "OwoMRHsaQwyAgVoc3OXmL1JhMVUYXGGBbCTK0GBgiYitwQwjf0gVoBmkbuyy0pSi"
}
```
 
<h2 id="colab">🤝 Thành viên</h2>

<p>Trân trọng cảm ơn những người đã tham gia dự án tốt nghiệp. Hy vọng các bạn gặt hái được nhiều thành công trên con đường đã chọn</p>
<table>
<tr>

<td align="center">
<a href="https://github.com/PhamNhatHoang">
<img src="https://thanhcongfarm.com/wp-content/uploads/2022/05/anh-cho-hai-20.jpg" width="100px;" alt="Phạm Nhật Hoàng Profile Picture"/><br>
<sub>
<b>Phạm Nhật Hoàng</b>
</sub>
</a>
</td>

<td align="center">
<a href="https://github.com/ShaanCoding">
<img src="https://thanhcongfarm.com/wp-content/uploads/2022/05/anh-cho-hai-20.jpg" width="100px;" alt="Đỗ Minh Tâm Profile Picture"/><br>
<sub>
<b>Đỗ Minh Tâm</b>
</sub>
</a>
</td>

<td align="center">
<a href="https://github.com/tamXinchao">
<img src="https://thanhcongfarm.com/wp-content/uploads/2022/05/anh-cho-hai-20.jpg" width="100px;" alt="Lê Hoàng Hiền Profile Picture"/><br>
<sub>
<b>Lê Hoàng Hiền</b>
</sub>
</a>
</td>

<td align="center">
<a href="https://github.com/Chanh03">
<img src="https://thanhcongfarm.com/wp-content/uploads/2022/05/anh-cho-hai-20.jpg" width="100px;" alt="Ngô Việt Anh Profile Picture"/><br>
<sub>
<b>Ngô Việt Anh</b>
</sub>
</a>
</td>

<td align="center">
<a href="https://github.com/PhamNhatHoang">
<img src="https://thanhcongfarm.com/wp-content/uploads/2022/05/anh-cho-hai-20.jpg" width="100px;" alt="Nguyễn Trọng Phúc Profile Picture"/><br>
<sub>
<b>Nguyễn Trọng Phúc</b>
</sub>
</a>
</td>

</tr>
</table>
 
<h2 id="contribute">📫 Đóng góp</h2>

Here you will explain how other developers can contribute to your project. For example, explaining how can create their branches, which patterns to follow and how to open an pull request

1. `git clone https://github.com/PhamNhatHoang/DATN_Fpoly.git`
2. `git checkout -b feature/YOUR_BRANCH`
3. Thực hiện theo các cam kết
4. Mở Pull Request và chờ
 
<h3>Thông tin có thể hữu ích</h3>

[📝 How to create a Pull Request](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Commit pattern](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)
