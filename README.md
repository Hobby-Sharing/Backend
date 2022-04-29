# **🎮 MODU**

모두, 내 주변 이웃들과 취미를 공유하세요!

![https://user-images.githubusercontent.com/21170717/121205986-0f84e180-c8b3-11eb-9573-3e06063fe6cf.jpg](https://user-images.githubusercontent.com/21170717/121205986-0f84e180-c8b3-11eb-9573-3e06063fe6cf.jpg)

## 💡 **서비스 및 프로젝트 소개**

`**모두**` 는 주변 이웃들과 함께 취미를 공유할 수 있는 커뮤니티 서비스입니다. 사용자들은 온라인으로 자신이 살고 있는 동네를 기반으로 이웃들과 관심사에 대해 정보를 교류하고, 관심사를 공유하고, 취미를 전파하기 위한 자신만의 클럽을 개설할 수 있습니다! 

## **🚀 프로젝트 목표**

서비스의 기능을 구현하는 것 자체도 중요하지만, **어떤 과정을 통해 어떻게 구현했는지**가 그 이상으로 중요하다고 생각합니다. 예를 들어, 실무에서는 개인이 아닌 팀 단위로 개발을 진행하기 때문에 합의된 코드 스타일과 개발 프로세스를 유지해야 하고 효율적인 협업 방식을 고려해야 합니다. 또 실무에서의 서비스 규모는 훨씬 크고 복잡하기 때문에 유지보수성을 고려하여 변화를 쉽게 수용할 수 있는 유연한 설계를 유지해야 합니다. 따라서 `**모두**` 에서는 아래와 같은 목표들을 세운 후, 실제 운영 중인 서비스를 개발하는 상황에서 어떻게 이와 같은 목표를 달성할 수 있을지 고민하며 개발을 진행하고 있습니다.

1. **유연한 설계와 확장성 높은 코드로 유지보수성을 높이자**
    - 중복되는 코드들, 기능을 수정하고 추가할 때 마다 불필요한 작업을 해야만 하는 상황들을 최소화하고 유지보수성을 높이기 위해 노력합니다.
    - 이를 위해 SOLID 원칙과 디자인 패턴에 대한 이해를 바탕으로 객체지향의 장점을 최대한 활용하는 코드를 작성하고자 노력합니다.
2. **테스트 코드를 통해 개발한 코드의 신뢰를 높이자**
    - 안정적인 서비스를 개발하기 위해 테스트 코드는 필수입니다. 꼼꼼히 작성된 테스트 코드들은 개발한 코드의 올바른 동작을 보장해주며 이를 통해 다른 팀원들에게도 신뢰를 줄 수 있습니다. 또 잘 작성된 테스트 코드 목록은 전체적인 서비스를 파악할 수 있는 하나의 명세서 역할을 하기도 합니다.
3. **문서화를 통해 협업 효율성을 높이자**
    - 여러 분야의 팀원들이 협업하는 환경에서 요청과 응답 방식에 대해 잘 정리된 API 문서는 원활한 커뮤니케이션을 도와주는 이정표가 됩니다. 뿐만 아니라 외부의 사용자가 우리가 개발한 API를 호출하기 위해서도 API 문서는 필수적입니다.
    - 위와 같은 이유 때문에, Notion으로 가독성 높은 API 명세를 작성하고자 합니다.

## **🔧 사용 기술 스택**

- Java 17
- Spring Boot
- Spock
- MySQL
- QueryDSL
- Redis
- OpenFeign
