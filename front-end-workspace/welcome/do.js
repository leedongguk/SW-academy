/* function type1(){
    let data = 10;
    setTimeout(() => {
        let data = 100;
        
    }, 3000);
    console.log(data);
}

type1();

function type2(callback){
    let data = 10;
    setTimeout(() => {
        data = 100;
        callback(data);
    })
}

const cb =function mycallback(data){
    console.log(data);
}*/

function test(callback){
    let data = 10;
    setTimeout(() => {
    data = 100;
    callback(date);
    },3000);
    console.log(date);
}

let cb2 = function handle(data){
    console.log(data);
}

//type2(cb2);

function type3(){
    return new Promise(function(resolve,reject){
        let data = 10;
        setTimeout(() => {
            data = 100;
            resolve(data);
        }, 3000);
    });
}
/*
type3.then(function(result){
    console.log(result);
});
*/
async function type4(){
    let result = await type3();
    console.log(result);
}

type4();
