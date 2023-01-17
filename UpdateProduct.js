import { Link } from 'react-router-dom';
import { useState } from 'react';
import '../App.css'

function UpdateProduct(){
    const [product_id,setid] = useState('');
    const [product_name,setname] = useState('');
    const [product_category,setcategory] = useState('');
    const [product_price,setprice] = useState('');
    
    const updateProduct = () =>{
    let data = {
        product_id: product_id,
        product_name: product_name,
        product_category: product_category,
        product_price: product_price
   }
    fetch('http://localhost:8097/api/v2/Product/${product_id}',{
    method:"PUT",
    body: JSON.stringify(data),
    headers : {
        "Content-Type":"application/json",
        "Access-Control-Allow-Origin":"*"
    }
   }).then(response => response.json())
     .then(json => console.log(json));
     alert("Product Updated Successfully !!! ")
    }


    //const AddProduct =() => {
    return(
        <div id="signup-div">
        <h1> Update Product </h1>
        Id: <input type="number" onChange={ (e) => setid(e.target.value)}/> <br/><br/>
        Name: <input type="text" onChange={ (e) => setname(e.target.value)}/> <br/><br/>
        category: <input type="text" onChange={ (e) => setcategory(e.target.value)}/> <br/><br/>
        price: <input type="text" onChange={ (e) => setprice(e.target.value)}/> <br/><br/>
        
        <button onClick={updateProduct}> Update Product </button><br/><br/>
        <Link to="/home"> Home </Link>
    </div>
)
    
    }

export default UpdateProduct
