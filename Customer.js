import { useEffect, React, useState } from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';
import '../App.css'


function Customer(){
    const [Customer,setCustomer] = useState([]);
    const url = `http://localhost:8090/api/v1/getAllCustomers`;
    
    const deletecustomer= (customerId) =>{
      const url =`http://localhost:8090/api/v1/delete_customer/${customerId}`;
      axios.delete(url).then(() =>{
        alert('Customer is deleted')
        axios.get(`http://localhost:8090/customer`).then( res => { setCustomer(res.data)})
      })
    }
    
    const searchHandle = async (event)=>{
      let key = event.target.value;
      if(key){
          let result = await fetch(`http://localhost:8090/api/v1/get_customer/${key}`);
          result = await result.json()
          if(result){
              setCustomer(result)
          }
      }else{
          Customer();
      }
      
  }
    useEffect ( () =>{
      axios.get(url).then( res => {
        //console.log(res.data);
        setCustomer(res.data);
      })
    }, []);

    return(
      <div className="customer-list">
      
      {
        
        <h1> Customer List</h1> 
        }

<table id="customer-table">
              <thead>
                  <th> customerId </th>
                  <th> fullName </th>
                  <th> mailId </th>
                  <th> mobileNo </th>
                  <th> order </th>
                  
              </thead>
              {Customer.map(c => <tr  key={c.customerId}>
                  
                  <td >{c.customerId}</td>
                  <td>{c.fullName}</td>
                  <td>{c.mailId}</td>
                  <td>{c.mobileNo}</td>
                  <td>{c.order}</td>
                  
                  
                  <td><Link to={"/update"}>Update</Link></td>
                  <td><button onClick={() => deletecustomer(c.customerId)}>Delete</button></td> </tr>)}
                </table>
            </div>



      // <div className="customer-list">
      //   <h1> Customers List</h1>
      //   <input type="" className='search-customer-box' placeholder='Search Customer'
      //       onChange={searchHandle}
      //        />
      //   <ul>
            
      //         <li> customerId </li>
      //         <li> fullName </li>
      //         <li> mailId </li>
      //         <li> mobileNo </li>
      //         <li> order </li>
      //       </ul>
      //       {Customer.length>0 ? Customer.map (c => 
      //                       <ul key={c.customerId}>
      //                       <li>{c.customerId}</li>
      //                       <li>{c.fullName}</li>
      //                       <li>{c.mailId}</li>
      //                       <li>{c.mobileNo}</li>
      //                       <li>{c.order}</li>
      //                       <li><Link to={"/update"}>Update</Link></li>
      //                       <li><button onClick={()=>deletecustomer(c.customerId)}> Delete </button></li>
      //                       </ul>
      //                       ): <h2 >No Result Found</h2>
      //                     }
      //                       <Link id="link" to="/home"> Home </Link><br/>
      //                       <Link id="link" to="/add">  AddCustomer </Link>
        
      //   </div>
    )
}

export default Customer