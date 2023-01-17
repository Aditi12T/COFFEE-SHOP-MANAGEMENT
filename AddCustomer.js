import { Link } from 'react-router-dom';
import { useState } from 'react';
import '../App.css'

function AddCustomer(){
    const [cid,setcid] = useState('');
    const [cfullName,setfullname] = useState('');
    const [cmailId,setmailId] = useState('');
    const [cmobileNo,setmobileNo] = useState('');
    const [corder,setorder] = useState('');
    
    const addCustomer = () =>{
    let data = {
        customer_Id: cid,
        full_Name: cfullName,
        customermailId: cmailId,
        customermobileNo: cmobileNo,
        customerorder: corder

       }
    fetch('http://localhost:8090/api/v1/addCustomer',{
    method:"POST",
    body: JSON.stringify(data),
    headers : {
        "Content-Type":"application/json",
        "Access-Control-Allow-Origin":"*"
    }
   }).then(response => response.json())
     .then(json => console.log(json));
     alert("Customer updated Successfully !!! ")
    }


    //const AddProduct =() => {
    return(
        <div id="signup-div">
            <h1> add Customer </h1>
            Customer Id: <input type="number" onChange={ (e) => setcid(e.target.value)}/> <br/><br/>
            fullName: <input type="text" onChange={ (e) => setfullname(e.target.value)}/> <br/><br/>
            mailId: <input type="text" onChange={ (e) => setmailId(e.target.value)}/> <br/><br/>
            mobileNo: <input type="text" onChange={ (e) => setmobileNo(e.target.value)}/> <br/><br/>
            order: <input type="text" onChange={ (e) => setorder(e.target.value)}/> <br/><br/>
            <button onClick={AddCustomer}> Add Customer </button><br/><br/>
            <Link to="/home"> Home </Link>
        </div>
    )
    }

export default AddCustomer