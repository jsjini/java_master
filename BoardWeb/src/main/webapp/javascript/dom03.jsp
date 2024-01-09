<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>272p ~ 273p</title>
    </head>

    <body>
        <p>실습</p>
        <ul id="friends">
            <li class="animal">라이언</li>
            <li class="fruit">어피치</li>
            <li class="animal">프로도</li>
            <li class="alien">콘
                <ul class="keyword">
                    <li>3세</li>
                    <li>숏다리</li>
                    <li>초록괴수</li>
                </ul>
            </li>
        </ul>
        <ul class="icons">
            <li>
                <span>스몰</span>
                <span>미디엄</span>
                <span>거대</span>
            </li>
        </ul>
        <ul id="newfriends">
        </ul>
        <p id="paragraphid"></p>
        <script>
            let li = document.createElement('li');
            let litext = document.createTextNode('무지');
            li.appendChild(litext);

            let targetul = document.getElementById('friends');
            targetul.appendChild(li);

            let sourceli = document.querySelector('ul#friends li:first-child');
            let targetli = document.querySelector('ul#friends li:last-child');
            targetli.after(sourceli);

            var appendli = document.createElement("li");
            appendli.append('왕눈이');
            document.querySelector('ul li ul').append(appendli);

            let selected = document.querySelector('.icons li span:last-child');

            let newspan = document.createElement('span');
            let newspantext = document.createTextNode('빅');
            newspan.appendChild(newspantext);
            selected.parentNode.insertBefore(newspan,selected);

            let items = document.querySelectorAll('.animal');
            document.querySelector('#newfriends').prepend(...items);

            let p = document.createElement('p');
            let ptext = document.createTextNode('문단 텍스트 내용');
            p.appendChild(ptext);
            selected.appendChild(p);
            let originalp = document.getElementById('paragraphid');

            let oldp = originalp.parentNode.replaceChild(p, originalp);
        </script>
    </body>

    </html>