# 📘 Social Media API 測試手冊

## Start the application

```bash
    ./mvnw spring-boot:run
```

## 🔐 Auth

### 🔸 登入取得 Token  

**POST** `http://localhost:8080/api/auth/token`

```json
{
  "phone": "0911111114",
  "password": "123"
}
```

### 🔸 註冊使用者  

**POST** `http://localhost:8080/api/auth/user`

```json
{
  "phone": "0911111114",
  "password": "123"
}
```

---

## 📝 Posts

### 🆕 建立貼文

**POST** `http://localhost:8080/api/posts`

```json
{
  "content": "這是我的新貼文",
  "image": "https://image.url",
  "user": {
    "id": 1
  }
}
```

### ✏️ 編輯貼文  

**PUT** `http://localhost:8080/api/posts/2`

```json
{
  "content": "這是我的新貼文(更新)",
  "image": "https://image.url"
}
```

### ❌ 刪除貼文  

**DELETE** `http://localhost:8080/api/posts/3`

---

## 💬 Comments

### 🗨️ 新增留言  

**POST** `http://localhost:8080/api/comments`

```json
{
  "content": "這是一則留言",
  "postId": 2
}
```
