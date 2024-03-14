const express = require('express');
const app = express();

//서버준비
app.listen(3300,() => {
    console.log('Server running at http://localhost:3300');
});

app.use(express.urlencoded({
    extended : false
}));


//요청 처리
// id 는 간단하게 숫자
let userCounter = 0;
const users = []; // 사용자 컬렉션 -> 배열

app.get('/user',(request,response)=>{
    response.send(users); // 전체조회는 딱히 객체를 받을 필요가 없음.
});

app.get('/users/id',(request,response)=>{
    let id = request.params.id;
    // id 추출한다음에 해당 id의 user를 검색해서 클라이언트로 전송
    const member = {};
    for(let i = 0; i<users.length; i++){
        console.log(users[i])
    }
    response.send(member);
});

// 조건 조회 , 사용자 id로 검색
app.post('/user/:id',(request,response)=>{

    const body = request.body;

    const member = {
        id : userCounter++,
        name: body.name,
        region: body.region
    };

    users.push(member);

    response.send(users);
});

app.put('/user/:id',(request,response)=>{
    
    let id = request.params.id;
    let body = request.body;
    const member = {};
    for(let i = 0; i<users.length; i++){
        if(users[i].id == id){
            users[i].name = body.name;
            users[i].region = body.region;
            member = users[i];
        }
    }
    
    response.send(users[i]);

});

app.delete('/user/:id',(request,response)=>{
    let id = request.params.id;
    let index = 0;
    for(let i = 0; i < users.length; i++){
        if(users[i].id == id){
            index = 1;
        }
    }
    const member = users.splice(0,1);
    response.send(member);
});
