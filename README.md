# 🤖 Telegram Bot Projesi 

Bu proje, bir Telegram botu oluşturmak için geliştirilmiştir. Bot, belirli aralıklarla kelime quizleri gönderir ve basit bir HTTP sunucusu çalıştırır.

<br><br>
## 🚀Başlarken

Bu talimatlar, yerel makinenizde projeyi çalıştırmak için gereken adımları sağlar.

<br><br>
## 🛠️Gereksinimler

- Java 17
- Maven

<br><br>
## 💾Kurulum

1. Projeyi klonlayın:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. Gerekli bağımlılıkları yükleyin:
   ```bash
   mvn clean install
   ```

3. `config.properties` dosyasını düzenleyin ve bot token ve kullanıcı adını girin:
   ```properties
   bot.token = <YOUR_BOT_TOKEN>
   bot.username = <YOUR_BOT_USERNAME>
   bot.chatId = <CHANNEL_CHAT_ID>
   ```

<br><br>
## ▶️Çalıştırma

Projeyi çalıştırmak için aşağıdaki komutu kullanın:
  ```bash
  mvn exec:java -Dexec.mainClass="org.example.Main"
  ```

<br><br>
## ⚙️Yapılandırma

- `pom.xml` dosyasında, Java 17 kullanımı ve gerekli bağımlılıklar tanımlanmıştır.
- Botun ayarları için bir `config.properties` dosyası gereklidir. Bu dosyada bot token, kullanıcı adı ve kanalın chat ID'si gibi bilgiler bulunur.
  (Örnek bir dosya yoksa, yukarıdaki formatta manuel olarak resources klasörünün altına ekleyin)
- `words.json` dosyasında, "word"-"definition" keyleri bulunur. (Dilerseniz mevcut bir JSON dosyasını kullanabilir ya da kendi kelime listenizi manuel olarak ekleyebilirsiniz.)
  (Bu dosyayı da "resources/data" klasörünün altında oluşturabilirsiniz.)

```
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │       ├── config.properties
│   │       └── data
│   │           └── words.json
```


<br><br>
### Örnek JSON
```
[
  {
    "word": "algorithm",
    "definition": "algoritma"
  },
  {
    "word": "apple",
    "definition": "elma"
  }
]
```

<br><br>
## ✨Özellikler

- **Kelime Quizleri**: Bot, belirli aralıklarla(5 dakika) kelime quizleri gönderir.
- **HTTP Sunucusu**: Basit bir HTTP sunucusu çalıştırır ve botun çalıştığını doğrular.

<br><br>
## 🔍Test ve Hata Ayıklama
 **Cannot parse null string**
- Eğer projeyi Heroku üzerinde çalıştırıyorsanız, ortam değişkenlerinden `PORT` değerini alın.  
Ancak, projeyi lokal ortamda çalıştırırken `application.properties` ya da `config.properties` dosyasına şu satırı ekleyebilirsiniz:  
```properties  
server.port=8080  
```

<br><br>
## 🤝Katkıda Bulunma

1. Projeyi forklayın.
2. Yeni bir branch oluşturun (`git checkout -b feature/AmazingFeature`).
3. Değişikliklerinizi işleyin (`git commit -m 'Add some AmazingFeature'`).
4. Branch'e push yapın (`git push origin feature/AmazingFeature`).
5. Bir Pull Request açın.

<br><br>
## 💬İletişim

Proje hakkında sorularınız veya önerileriniz için lütfen [Muhammet Kaya](mailto:kayamuhammet78@gmail.com) adresine e-posta gönderin.

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/muhammet-kaya-81a8b81b0/)
