<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="show">
    <table class="table">
        <thead>
            <tr>
                <th>센터id</th>
                <th>센터명</th>
                <th>연락처</th>
                <th>시도정보</th>
                <th>주소</th>
            </tr>
        </thead>
        <tbody id="list"></tbody>
    </table>
</div>
<script>
const url ='https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey=02RFiwEXkug23AQuMdn0yFgtH24GTlGUzXBF3wPEj0D7po0QWoY37eNbYGTxLNmb%2FH7Y89Uh8RhQoOjxThsjgA%3D%3D';
const fields = ['id', 'centerName', 'phoneNumber', 'sido', 'address'] // 화면에 보여줄 항목 지정

let tbody = document.getElementById("list");
const xhtp = new XMLHttpRequest();
xhtp.open('get', url);
xhtp.send();
xhtp.onload = function() {
    console.log(JSON.parse(xhtp.responseText));
    // tr > td * n
    let result = JSON.parse(xhtp.responseText);
    result.data.forEach(item => {
        let tr = document.createElement('tr');
        tr.addEventListener('click', function() {
            //location.href = 'map.do?x='+item.lat+'&y='+item.lng;
            window.open("map.do?x="+item.lat+"&y="+item.lng+"&z="+encodeURI(item.org));
        })
        fields.forEach(field => {
            let td = document.createElement('td');
            td.innerText = item[field];
            tr.appendChild(td);
        })
        tbody.appendChild(tr);
    });
}

</script>
</body>
</html>