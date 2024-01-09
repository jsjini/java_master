<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>

        <div id="show"></div>

        <script>
            let show = document.getElementById('show'); // id값으로 요소를 선택
            let cnt = 0;
            /* setInterval(() => {   // setInterval(실행 함수, 지연시간) - 지연시간으로 계속 반복
                const today = new Date();
                let hh = today.getHours();
                let mm = today.getMinutes();
                let ss = today.getSeconds();
                cnt++;
                
                if(cnt >= 20){
                    clearInterval(interval);
                }
                show.innerHTML = hh + "시 " + mm + "분 " + ss + "초 <br>";

            }, 1000); */


            const promise = new Promise(function (resolve, reject) {
                setTimeout(function () {  // setTimeout(실행할 함수, 몇초 후 실행(밀리초) -한번만 지연
                    reject('Fail');
                }, 3000);

            }); // pending(초기화) -> fullfilled (정상처리) -> rejected (비정상처리)
            promise.then(function (result) {
                console.log('then=> ', result);
                return 'ok';
            })
                .then(function (result) {
                    console.log('second then=> ', result)
                })
                .catch(function (err) {
                    console.error('error=> ', err);
                });
        </script>

    </body>

    </html>