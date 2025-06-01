# PetStore API Test Automation

Bu proje, Swagger PetStore API'sinin Java dilinde Rest Assured ile test otomasyonunu içermektedir. Page Object Model (POM) prensibi kullanılarak hazırlanmıştır.

## Proje Yapısı

```
src/test/java/
├── api
│   ├── assertions        - Özel assertion sınıfları
│   ├── config            - API test konfigürasyonu
│   ├── endpoints         - API endpoint sınıfları
│   ├── models            - API veri modelleri
│   └── tests             - Test sınıfları
│       └── pet           - /pet endpoint testleri
src/test/resources/
└── logback-test.xml      - Loglama konfigürasyonu
```

## Kullanılan Teknolojiler

- Java 17
- JUnit 5
- Rest Assured
- AssertJ
- Jackson (JSON işlemleri)
- Logback (Loglama)

## Mimari Yaklaşım

Bu projede Page Object Model'e benzer bir mimari yaklaşım kullanılmıştır:

1. **Endpoint Sınıfları**: Her API endpoint'i için ayrı sınıflar oluşturulmuştur. Bu sınıflar, ilgili endpoint'lere yapılacak istekleri kapsüller.

2. **Model Sınıfları**: API'nin kullandığı veri modelleri için POJO sınıfları tanımlanmıştır.

3. **Test Sınıfları**: Her endpoint için ayrı test sınıfları oluşturulmuştur.

4. **Assertion Sınıfları**: Test doğrulamaları için özel assertion sınıfları eklenmiştir.


## Testlerin Kapsamı

Bu test suite'i, `/pet` endpoint'i altındaki tüm API metodlarını test eder:

- `POST /pet` - Yeni bir evcil hayvan ekleme
- `PUT /pet` - Mevcut bir evcil hayvanı güncelleme
- `GET /pet/findByStatus` - Duruma göre evcil hayvan arama
- `GET /pet/{petId}` - ID'ye göre evcil hayvan getirme
- `POST /pet/{petId}` - Form verisi ile evcil hayvan güncelleme
- `DELETE /pet/{petId}` - Evcil hayvan silme
