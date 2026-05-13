# 📧 AI-Powered Email Writer Assistant

An intelligent, full-stack email writing assistant that generates context-aware, tone-customized email replies using the **Gemini AI API**. Built with a Spring Boot backend and a ReactJS frontend with Material UI.

---

## 🚀 Features

- **AI-Powered Generation** — Integrates Google Gemini AI to produce professional, context-aware email replies
- **Tone Customization** — Supports multiple tones: Formal, Casual, Persuasive, and Friendly
- **Clean UI** — Intuitive React frontend with Material UI for a polished user experience
- **Copy to Clipboard** — One-click copy of generated replies
- **RESTful Architecture** — Clean layered backend with modular, scalable design

---

## 🛠️ Tech Stack

| Layer      | Technology                          |
|------------|--------------------------------------|
| Backend    | Java, Spring Boot, REST APIs         |
| AI         | Gemini AI API, Prompt Engineering    |
| Frontend   | ReactJS, Material UI, HTML, CSS      |
| Extension  | Chrome Extension (Manifest V3)       |
| Build Tool | Maven                                |
| Version Control | Git, GitHub                     |

---

## 📸 Screenshot

![Email Writer UI](screenshot.png)

---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Node.js 18+
- Maven
- Gemini API Key ([Get one here](https://makersuite.google.com/app/apikey))

---

### 1. Clone the Repository

```bash
git clone https://github.com/Jatin0Yadav/ai-email-writer.git
cd ai-email-writer
```

---

### 2. Backend Setup

Navigate to the backend directory:

```bash
cd backend
```

Create an `application.properties` file or set environment variables:

```properties
gemini.api.key=YOUR_GEMINI_API_KEY
server.port=8080
```

Or export as environment variable:

```bash
export GEMINI_API_KEY=your_api_key_here
```

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

Backend will start at `http://localhost:8080`

---

### 3. Frontend Setup

Navigate to the frontend directory:

```bash
cd frontend
npm install
npm start
```

Frontend will start at `http://localhost:5173`

---

## 📁 Project Structure

```
ai-email-writer/
├── backend/
│   ├── src/
│   │   ├── main/java/
│   │   │   ├── controller/       # REST API endpoints
│   │   │   ├── service/          # Gemini AI integration & business logic
│   │   │   └── model/            # Request/Response models
│   │   └── resources/
│   │       └── application.properties
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── components/           # Reusable UI components
│   │   ├── App.jsx
│   │   └── index.js
│   └── package.json
└── README.md
```

---

## 🔑 Environment Variables

| Variable        | Description                  | Required |
|-----------------|------------------------------|----------|
| `GEMINI_API_KEY` | Your Google Gemini API key  | ✅ Yes   |

> ⚠️ Never commit your API key to the repository. Add `application.properties` to `.gitignore`.

---

## 🔗 API Endpoints

| Method | Endpoint          | Description                        |
|--------|-------------------|------------------------------------|
| POST   | `/api/email/generate` | Generate AI email reply        |

### Request Body

```json
{
  "emailContent": "Original email text here",
  "tone": "formal"
}
```

### Response

```json
{
  "generatedReply": "AI generated email reply here..."
}
```

---

## 🙋‍♂️ Author

**Jatin Yadav**  
- GitHub: [@Jatin0Yadav](https://github.com/Jatin0Yadav)  
- LinkedIn: [linkedin.com/in/izatin07](https://linkedin.com/in/izatin07)
