<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>

        <script>
            fetch('data.json', {  // fetch(서버url, option객체) - get 방식이면 옵션 불필요
                method: 'post',
                mode: 'cors',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'x=120&y=200'
            })
                .then(result => {
                    console.log(result);
                    return result.json();
                })
                .then(json => {
                    console.log(json);
                })
                .catch(error => {
                    console.log(error);
                })

        </script>

    </body>

    </html>