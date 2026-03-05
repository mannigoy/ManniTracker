# 💸 ManniTracker

A personal finance tracker that automatically reads your **GCash transaction history** from encrypted PDF exports and organizes your spending and received money by category — so you always know where your money goes.

---

## 📋 Description

ManniTracker takes the hassle out of manually tracking your GCash transactions. Simply upload your GCash PDF statement, enter your password, and the app does the rest — parsing every transaction, categorizing your spending, and giving you a clear dashboard of your financial activity. No more scrolling through your GCash app trying to remember what you spent last month.

---

## ✨ Features

- 📄 **GCash PDF Upload** — Upload your encrypted GCash transaction PDF directly in the app
- 🔓 **Automatic PDF Decryption** — Enter your GCash PDF password and the app handles the decryption
- 📊 **Spending by Category** — Transactions are automatically categorized (Food, Transport, Shopping, Bills, etc.)
- 💰 **Money Received Tracking** — Separate view for all money you received
- 📅 **Monthly Summary** — See your total spent and received per month at a glance
- 🔐 **Secure Authentication** — Register and log in with your email, verified before access is granted

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Frontend | React + Vite + Tailwind CSS |
| Backend | Spring Boot (Java) + Maven |
| Database | Supabase (PostgreSQL) |
| Auth | Supabase Auth |
| File Storage | Supabase Storage |
| PDF Parsing | Apache PDFBox (via Spring AI PDF Reader) |
| Security | Spring Security + JWT |

---

## 🚀 Usage

### 1. Register
Create an account using your email address and a password.

### 2. Verify Your Email
Check your inbox for a verification email from ManniTracker and click the confirmation link before logging in.

### 3. Upload Your GCash PDF
- Go to the **Upload** page
- Select your GCash transaction PDF
- Enter your GCash PDF password *(this is usually your birthday in MMDDYYYY format)*
- Click **Upload** and wait for the app to parse your transactions

### 4. Track Your Spending & Received Money
- Head to the **Dashboard** to see your total spent vs received
- View a full breakdown of all your parsed transactions

### 5. View by Category
- Go to **Categories** to see how much you spent per category
- Categories are automatically assigned based on transaction descriptions
- *(e.g. Jollibee → Food, Grab → Transport, Netflix → Entertainment)*

---

> ⚠️ **Privacy Note:** Your GCash PDF password is used only to decrypt the file during upload and is never stored.
