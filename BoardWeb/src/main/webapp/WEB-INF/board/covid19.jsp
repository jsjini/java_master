<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>

    </head>

    <body>
        <style>
            .pagination {
                display: inline-block;
            }

            .pagination a {
                color: black;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }

            .pagination a.active {
                background-color: #4CAF50;
                color: white;
            }

            .pagination a:hover:not(.active) {
                background-color: #ddd;
            }
        </style>
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
        <div style="text-align:center;">
            <div id="paging" class="pagination">
            </div>
        </div>
        <script>
            let page = 1;
            
            function pageList(e) {
                e.preventDefault();
                page = this.getAttribute("href");
                showList(page);
                // 페이지를 생성하는 함수를 호출.
                pagingList(page);
            }
            
            let tbody = document.getElementById("list");
            function showList(page) {
                console.log(page);
                tbody.innerHTML = '';
                const url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=' + page + '&perPage=10&serviceKey=02RFiwEXkug23AQuMdn0yFgtH24GTlGUzXBF3wPEj0D7po0QWoY37eNbYGTxLNmb%2FH7Y89Uh8RhQoOjxThsjgA%3D%3D';
                const fields = ['id', 'centerName', 'phoneNumber', 'sido', 'address'] // 화면에 보여줄 항목 지정

                const xhtp = new XMLHttpRequest();
                xhtp.open('get', url);
                xhtp.send();
                xhtp.onload = function () {
                    // console.log(JSON.parse(xhtp.responseText));
                    // tr > td * n
                    let result = JSON.parse(xhtp.responseText);
                    result.data.forEach(item => {
                        let tr = document.createElement('tr');
                        tr.addEventListener('click', function () {
                            //location.href = 'map.do?x='+item.lat+'&y='+item.lng;
                            window.open("map.do?x=" + item.lat + "&y=" + item.lng + "&z=" + encodeURI(item.org));
                        })
                        fields.forEach(field => {
                            let td = document.createElement('td');
                            td.innerText = item[field];
                            tr.appendChild(td);
                        })
                        tbody.appendChild(tr);
                    });
                }
            }
            
            showList(page);
            pagingList();
            let paging = document.querySelector('#paging');
            function pagingList(pag = 1) {
                const url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=' + page + '&perPage=10&serviceKey=02RFiwEXkug23AQuMdn0yFgtH24GTlGUzXBF3wPEj0D7po0QWoY37eNbYGTxLNmb%2FH7Y89Uh8RhQoOjxThsjgA%3D%3D';
                const xhtp = new XMLHttpRequest();
                xhtp.open('get', url);
                xhtp.send();
                xhtp.onload = function () {
                    // tr > td * n
                    let result = JSON.parse(xhtp.responseText);
                    paging.innerHTML = '';
                    let realLast = Math.ceil(result.totalCount / 10);
                    let lastPage = Math.ceil(pag / 10) * 10;
                    let startPage = lastPage - 9;
                    if(lastPage > realLast) {
                        lastPage = realLast;
                    }
                    let prev = Boolean(startPage > 1);
                    let next = Boolean(lastPage < realLast);
                    console.log(realLast);
                    console.log(lastPage);
                    if (prev) {
        				let aTag = document.createElement('a');
        				aTag.href = startPage - 1;
        				aTag.innerText = '이전';
        				aTag.addEventListener('click', pageList);
        				paging.appendChild(aTag);
        			}
                    
                    for (let p = startPage; p <= lastPage; p++) {
                        let aTag = document.createElement('a');
                        if (p == pag) {
                            aTag.setAttribute('class', 'active');
                        }
                        aTag.href = p;
        				aTag.innerText = p;
        				aTag.addEventListener('click', pageList);
                        paging.appendChild(aTag);
                    }
                    
                    if (next) {
        				let aTag = document.createElement('a');
        				aTag.href = lastPage + 1;
        				aTag.innerText = '다음';
        				aTag.addEventListener('click', pageList);
        				paging.appendChild(aTag);
        			}
                    
                }
            }
            
            







        </script>
    </body>

    </html>