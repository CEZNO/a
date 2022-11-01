# a

코드 참고 및 출처 https://qh5944.tistory.com/50

java JDBC와 Oracle DB를 이용한 게시판 구현.

개선 사항

1. 아직 미완성.
2. 댓글과 게시글을 BoardDetail에서 볼 수 있게 만들었어야 함.

구현 시 애로 사항.

1. 실 작업 시, java 버전이 맞지 않아 Eclipse가 충돌되는 현상이 벌어짐.
2. JDBC 구동 시, Arraylist 오류가 발생. DB 자료형, java 변수 자료형을 수정하여 해결.
3. Board_List 외의 클래스가 java.lang.ArrayIndexOutOfBoundsException 오류를 뱉는 현상.
