# PbbsAttendance :blue_heart:
<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->




<!-- PROJECT LOGO -->
<br />
<div align="center">

  <h3 align="center">PbbsAttendance</h3>

  <p align="center">
    출결 후 도망가는 학생없는 수업을 만들 수 있는 희망찬 안드로이드 앱
    <br />
    <a href="https://github.com/GifticonRangers/WebServer">Web Server</a>
    ·
    <a href="https://github.com/GifticonRangers/multiple-object-tracking">AI server</a>
    ·
    <a href="https://github.com/GifticonRangers/raspberrypi-camera-server">Camera server</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Languages, libraries and tools used</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#feature">Feature</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project


출결 후 수업을 몰래 빠지는 학생들이 있어 정확한 출결처리에 지장을 주고 있습니다. PBBS 팀은 부정출결 문제를 해결하기 위해 새로운 출결시스템을 개발했습니다.카메라로 찍은 영상을 Object Dectecting으로 분석하고 수업의 부정출결자를 판단합니다. 또한 각 책상에 부착된 NFC 태그의 고유번호로 해당 수업 출결을 수행합니다.

Pbbs Attendance는 Pbbs 팀의 새로운 출결 시스템을 교수와 학생 모두에게 효과적으로 경험시켜줄 앱입니다.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Languages, libraries and tools used

* Kotlin
* Android Jetpack Libraries
* Coroutine
* Hilt
* Glide
* Retrofit2
* OkHttp
* Gson
* Espresso
* Compose
* WorkManager

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started
1. 구글 플레이 스토어 출시예정입니다.
2.  Clone the repo
   ```sh
   git clone https://github.com/GifticonRangers/PbbsAttendance-android.git
   ```



<!-- USAGE EXAMPLES -->
<!--Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources. -->
## Usage
1. Home Scheduler Component

### 1. Universal Screen
### 2. Professor-only Screen 
### 3. Student-only Screen

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- FEATURE EXAMPLES -->
## Feature
### 1. NFC background reading

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

- [ ] presentation 계층 UI 구성
- [ ] domain useCase 생성
- [ ] data 계층 인터페이스 설계 (for web-server, ai-server)
- [ ] 백그라운드로 5분마다 nfc 고유번호 전송 기능
- [ ] 영어버전 지원 기능(외국인 교수들을 위해)

See the [project issues](https://github.com/GifticonRangers/PbbsAttendance-android/issues) for a full list of proposed features(and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

LeeYongin - 
- instagram: [0517yongin](https://instagram.com/0517yongin)
- mail: yongin0517@gmail.com

Project Link: [PbbsAttendance-android](https://github.com/GifticonRangers/PbbsAttendance-android)
Project Team Link: [풍비박산(PBBS)](https://github.com/GifticonRangers)
<p align="right">(<a href="#readme-top">back to top</a>)</p>
