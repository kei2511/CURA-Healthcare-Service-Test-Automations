# 🏥 CURA Healthcare Service Test Automations

<div align="center">

![Katalon Studio](https://img.shields.io/badge/Katalon%20Studio-10.4.3-00A5B5?style=for-the-badge&logo=katalon&logoColor=white)
![Test Automation](https://img.shields.io/badge/Test%20Automation-Web%20UI-blueviolet?style=for-the-badge)
![Groovy](https://img.shields.io/badge/Groovy-4298B8?style=for-the-badge&logo=apache-groovy&logoColor=white)
![Data Driven](https://img.shields.io/badge/Data%20Driven-Testing-orange?style=for-the-badge)

**Automated UI Testing untuk CURA Healthcare Service menggunakan Katalon Studio**

[🔗 Demo Website](https://katalon-demo-cura.herokuapp.com/) • [📖 Dokumentasi](#-struktur-proyek) • [🚀 Getting Started](#-getting-started)

</div>

---

## 📋 Deskripsi Proyek

Proyek ini berisi **automated test scripts** untuk melakukan pengujian fungsional pada website [CURA Healthcare Service](https://katalon-demo-cura.herokuapp.com/). CURA Healthcare Service adalah demo website layanan kesehatan yang memungkinkan pengguna untuk:

- Login ke sistem
- Membuat janji temu (appointment) dengan dokter
- Memilih fasilitas kesehatan (Tokyo, Hongkong, Seoul)
- Memilih program healthcare (Medicare, Medicaid, None)

---

## ✨ Fitur Test Automation

| Fitur | Deskripsi |
|-------|-----------|
| 🔐 **Login Testing** | Pengujian validasi login dengan berbagai skenario (valid/invalid credentials) |
| 📅 **Appointment Booking** | Pengujian pembuatan janji temu dengan berbagai kombinasi data |
| 📊 **Data-Driven Testing** | Menggunakan external data files (Excel/DAT) untuk multiple test scenarios |
| 🔄 **Reusable Test Objects** | Object Repository yang terorganisir untuk kemudahan maintenance |

---

## 🏗️ Struktur Proyek

```
📦 CURA-Healthcare-Service-Test-Automations
├── 📁 Data Files/                    # Test data untuk data-driven testing
│   ├── 📄 DataLogin.xlsx             # Data login (username, password, expected)
│   ├── 📄 DataMakeAppointment.xlsx   # Data appointment
│   ├── 📄 Data_MakeAppointment.dat   # Data file format DAT
│   └── 📄 TestData_Login.dat         # Login test data format DAT
├── 📁 Object Repository/             # UI Element locators
│   └── 📁 Page_CURA Healthcare Service/
│       ├── btn_Book Appointment.rs
│       ├── btn_Login.rs
│       ├── btn_MakeAppointment.rs
│       ├── txt_username.rs
│       ├── txt_password.rs
│       └── ... (element lainnya)
├── 📁 Scripts/                       # Groovy test scripts
│   ├── 📁 Login_test/
│   │   └── Script.groovy             # Login automation script
│   └── 📁 Make_appointment/
│       └── Script.groovy             # Appointment booking script
├── 📁 Test Cases/                    # Test case definitions
│   ├── Login_test.tc
│   └── Make_appointment.tc
├── 📁 Test Suites/                   # Test suite configurations
│   ├── TS_LoginData.ts               # Login test suite with data binding
│   ├── TS_LoginData.groovy
│   ├── TS_MakeAppointment.ts         # Appointment test suite
│   └── TS_MakeAppointment.groovy
├── 📁 Profiles/                      # Execution profiles
├── 📁 Include/                       # Additional scripts & configs
├── 📄 Belajar_Katalon.prj            # Katalon project file
├── 📄 build.gradle                   # Gradle build configuration
└── 📄 console.properties             # Console runner properties
```

---

## 🚀 Getting Started

### Prerequisites

1. **Katalon Studio** versi 10.4.3 atau lebih baru
   - Download: [https://katalon.com/download](https://katalon.com/download)
2. **Web Browser** (Chrome/Firefox/Edge)
3. **WebDriver** yang sesuai dengan versi browser

### Cara Menjalankan

1. **Clone repository ini:**
   ```bash
   git clone https://github.com/kei2511/CURA-Healthcare-Service-Test-Automations.git
   ```

2. **Buka proyek di Katalon Studio:**
   - File → Open Project
   - Pilih folder proyek yang sudah di-clone
   - Tunggu hingga proyek selesai di-load

3. **Jalankan Test Suite:**
   - Buka folder `Test Suites`
   - Klik kanan pada test suite yang diinginkan
   - Pilih `Run` atau `Run with [Browser]`

---

## 📝 Test Cases

### 1. Login Test (`Login_test`)

Test case ini memvalidasi fungsionalitas login dengan skenario:

| Skenario | Username | Password | Expected Result |
|----------|----------|----------|-----------------|
| Valid Login | John Doe | ThisIsNotAPassword | Redirect ke halaman Make Appointment |
| Invalid Login | wrong_user | wrong_pass | Menampilkan pesan login failed |

**Script Overview:**
```groovy
// Buka browser dan navigasi ke CURA website
WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

// Klik tombol Make Appointment untuk ke halaman login
WebUI.click(findTestObject('Page_CURA Healthcare Service/btn_MakeAppointment'))

// Input credentials dari test data
WebUI.setText(findTestObject('Page_CURA Healthcare Service/txt_username'), var_username)
WebUI.setText(findTestObject('Page_CURA Healthcare Service/txt_password'), var_password)

// Klik Login
WebUI.click(findTestObject('Page_CURA Healthcare Service/btn_Login'))

// Verifikasi hasil sesuai expected
if (var_expected == 'valid') {
    WebUI.verifyElementVisible(findTestObject('Page_CURA Healthcare Service/lbl_MakeAppointment'))
} else {
    WebUI.verifyElementVisible(findTestObject('Page_CURA Healthcare Service/txt_LoginFailed'))
}
```

### 2. Make Appointment Test (`Make_appointment`)

Test case ini memvalidasi proses pembuatan janji temu dengan berbagai kombinasi:

| Field | Options |
|-------|---------|
| Facility | Tokyo, Hongkong, Seoul |
| Hospital Readmission | Yes / No |
| Healthcare Program | Medicare, Medicaid, None |
| Visit Date | Date picker |
| Comment | Free text |

**Flow:**
1. Login dengan valid credentials
2. Pilih facility dari dropdown
3. Set hospital readmission checkbox
4. Pilih healthcare program (radio button)
5. Input visit date
6. Input comment
7. Book appointment
8. Verify confirmation page
9. Return to homepage

---

## 📊 Data-Driven Testing

Proyek ini menggunakan **Data-Driven Testing** approach dengan external data files:

### Test Data Files

| File | Format | Digunakan Untuk |
|------|--------|-----------------|
| `DataLogin.xlsx` | Excel | Multiple login scenarios |
| `TestData_Login.dat` | DAT | Login credentials |
| `DataMakeAppointment.xlsx` | Excel | Appointment combinations |
| `Data_MakeAppointment.dat` | DAT | Appointment data |

### Cara Menambah Test Data

1. Buka file Excel/DAT di folder `Data Files`
2. Tambahkan baris baru dengan data yang diinginkan
3. Simpan file
4. Test Suite akan otomatis iterate melalui semua baris data

---

## 🔧 Object Repository

Semua UI elements disimpan dalam Object Repository untuk:

- ✅ Centralized element management
- ✅ Mudah maintenance saat UI berubah
- ✅ Reusable di berbagai test cases

### Element yang tersedia:

| Category | Elements |
|----------|----------|
| **Buttons** | Make Appointment, Login, Book Appointment, Go To Homepage |
| **Text Fields** | Username, Password, Visit Date, Comment |
| **Dropdowns** | Facility (Tokyo, Hongkong, Seoul) |
| **Radio Buttons** | Healthcare Program (dynamic) |
| **Checkboxes** | Hospital Readmission |
| **Labels** | Page titles, Confirmation messages, Error messages |

---

## 🛠️ Technical Details

- **Katalon Version:** 10.4.3 Enterprise
- **Project Type:** Web UI
- **Scripting Language:** Groovy
- **Test Framework:** Katalon Studio built-in
- **Data Binding:** Test Suite level data binding

---

## 📌 Best Practices yang Diterapkan

1. **Page Object Pattern** - UI elements terorganisir per halaman
2. **Data-Driven Testing** - Separasi test logic dan test data
3. **Explicit Waits** - Menggunakan `waitForElementVisible` untuk stabilitas
4. **Failure Handling** - Konfigurasi `STOP_ON_FAILURE` untuk critical steps
5. **Encrypted Passwords** - Password disimpan dalam format encrypted

---

## 📄 License

Proyek ini dibuat untuk tujuan pembelajaran dan demonstrasi automated testing menggunakan Katalon Studio.

---

## 👤 Author

**Keisy** - [GitHub Profile](https://github.com/kei2511)

---

<div align="center">

⭐ **Jika proyek ini membantu, jangan lupa beri Star!** ⭐

</div>
