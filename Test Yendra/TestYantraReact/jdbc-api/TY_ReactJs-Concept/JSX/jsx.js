const element = < h1 > Hello world </h1>

const userName = "Dulquar"
const great = < h1 > Hello { userName } </h1>

const items=["Deodreant","Saree","Shoe"]

/* const list=<ul>
    <li>Deodreant</li>
    <li>Saree</li>
    <li>Shoe</li>
</ul> */

const list=<ul>
   {items.map((item,index)=>{
   return <li key={item+index} >{item}</li>
   })}
</ul>

ReactDOM.render(list, document.getElementById("react-container"))