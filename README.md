# inflearn-spring-boot(with Jpa)

## 테이블 설계
![테이블 설계](https://user-images.githubusercontent.com/52206904/156893740-190aba3a-07f3-4cd8-8c06-898a7dbaac3e.png)

## 객체 분석
![엔티티 분석](https://user-images.githubusercontent.com/52206904/156893747-824c07c7-39e2-43b5-bc96-2ff2779046f8.png)

## 테이블 분석
![회원 테이블 분석](https://user-images.githubusercontent.com/52206904/156893754-5dcef06b-14f5-4106-a5c3-89ae5af34abc.png)

카테고리 - 아이템
ManyToMany를 사용했다.
중간 테이블(CATEGORY_ITEM)에 컬럼을 추가할 수 없고, 세밀하게 쿼리를 실행하기 어렵기 떄문에 실무에서 사용하기에는 한계가 있다.
중간 엔티티(CategoryItem)을 만들고 @ManyToOne, @OneToMany로 풀어서 사용하자.
