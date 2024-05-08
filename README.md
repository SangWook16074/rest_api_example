# Spring Boot 백엔드 예제

Spring Boot & Kotlin으로 만든 간단한 RESTful API 예제입니다.

## HTTP method 종류

#### Get : 데이터를 단순하게 요청합니다.
#### Post : 부모리소스의 하위 리소스를 생성합니다.
#### Put : 데이터의 갱신을 요청합니다.
#### Delete : 데이터의 삭제를 요청합니다.

## Api 명세

<table style="text-align:center;border=1">
    <tr>
        <th><h3>메소드</h3></th>
        <th><h3>Url</h3></th>
        <th><h3>Status Code</h3></th>
        <th><h3>입력데이터</h3></th>
        <th><h3>파라미터</h3></th>
        <th><h3>반환데이터</h3></th>
    </tr>
    <tr>
        <td><h4>Get</h4></td>
        <td><h4>/humans</h4></td>
        <td><h4>200</h4></td>
        <td><h4>null</h4></td>
        <td><h4>null</h4></td>
        <td><h4>사람 목록을 조회합니다.</h4></td>
    </tr>
    <tr>
        <td><h4>Get</h4></td>
        <td><h4>/humans/{id}</h4></td>
        <td><h4>200</h4></td>
        <td><h4>null</h4></td>
        <td><h4>id : String</h4></td>
        <td><h4>id와 일치하는 사람 목록을 조회합니다.</h4></td>
    </tr>
    <tr>
        <td><h4>Post</h4></td>
        <td><h4>/humans</h4></td>
        <td><h4>201</h4></td>
        <td><h4>human : Human</h4></td>
        <td><h4>human : Human</h4></td>
        <td><h4>사람 정보를 생성합니다.</h4></td>
    </tr>
    <tr>
        <td><h4>Put</h4></td>
        <td><h4>/humans/{id}</h4></td>
        <td><h4>200</h4></td>
        <td><h4>human : Human</h4></td>
        <td><h4>id : String, human : Human</h4></td>
        <td><h4>사람 정보를 갱신합니다.</h4></td>
    </tr>
    <tr>
        <td><h4>Delete</h4></td>
        <td><h4>/humans/{id}</h4></td>
        <td><h4>200</h4></td>
        <td><h4>null</h4></td>
        <td><h4>id : String</h4></td>
        <td><h4>사람 정보를 삭제합니다.</h4></td>
    </tr>
</table>