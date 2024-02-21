import './App.css';

function Food(props){
  return <div>
    <h1>I like {props.name}</h1>
    <img style={{width: 100, height: 100 }} src={props.image} />
    </div>

}

const foodLike = [
  {
    name: 'potato',
    image: 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fnamu.wiki%2Fw%2F%25EA%25B0%2590%25EC%259E%2590%25EB%258F%2584%25EB%25A6%25AC&psig=AOvVaw0RuuxJjfspVshisaSC_LrM&ust=1708585512214000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCMjFhZfvu4QDFQAAAAAdAAAAABAI'
  },
  {
    name: 'sweet potato',
    image: 'https://www.sk5.co.kr/img_src/s600/b016//b0160603.jpg'
  },
  {
    name: 'apple',
    image: 'https://cdn.pixabay.com/photo/2018/02/02/01/07/cannibals-3124433_1280.jpg'
  }

];

function App() {
  return (
    <div>
      <h1>Hello React</h1>
      {foodLike.map((fruit) =>(<Food name={fruit.name} image = {fruit.image}/>
    ))}
    </div>
  );
}

export default App;
