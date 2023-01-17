import { useEffect, React, useState } from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';
import '../App.css'
function Products(){
    const [products,setProducts] = useState([]);
    const url = `http://localhost:8097/api/v2/getAllProducts`
    
    const deleteproduct= (product_id) =>{
      const url =`http://localhost:8097/api/v2/product/${product_id}`;
      axios.delete(url).then(() =>{
        alert('Product is deleted')
        axios.get(`http://localhost:8097/api/v2/product/${product_id}`).then( res => { setProducts(res.data)})
      })
    }
    
    const [searchcust,setSrchid] = useState([]);
    const srchById = (product_id) => {
    const url = `http://localhost:8097/api/v2/product/${product_id}`;
    axios.get(url).then(res => {
        setProducts(res.data);
        console.log(res.data);

    }).catch((_error) => {
      alert(`Product details not found!!!`)
    })
  }
      
  
    useEffect ( () =>{
      axios.get(url).then( res => {
        //console.log(res.data);
        setProducts(res.data);
      })
    }, []);

    return(
      <div className="product-list">
        <h1> Products List</h1>
        <input type="" className='search-product-box' placeholder='Search Product by ID'
            onChange={(e) => setSrchid(e.target.value)}
             />  
              <button onClick={() => srchById(searchcust)}>Search</button>
        <ul>
            
              <li> ID </li>
              <li> Name </li>
              <li> Category </li>
              <li> Price </li>
              <li> Edit</li>
              <li> Delete </li>
            </ul>
            {/*products.length>0 ?*/ products.map (p => 
                            <ul key={p.product_id}>
                            <li>{p.product_id}</li>
                            <li>{p.product_name}</li>
                            <li>{p.product_category}</li>
                            <li>{p.product_price}</li>
                            <li><Link to={"/update"}>Update</Link></li>
                            <li><Link className='updatebtn' onClick={()=>deleteproduct(p.product_id)}> Delete</Link></li>
                            
                            </ul>
                            )/*: <h2 >No Result Found</h2>*/
                          }
                            <Link id="link" to="/home"> Home </Link><br/>
                            <Link id="link" to="/add">  AddProduct </Link>
        
        </div>
    )
}

export default Products