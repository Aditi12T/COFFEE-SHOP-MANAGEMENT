import {Link} from 'react-router-dom';
import React, {useState} from 'react';
import'./App.css';

function Home(){
    const [count,setCount] = useState(0);
    return(
        <>
        <div id="home-div">
        <h2>COFFEE SHOP</h2>
        
        </div>
        <ul id="horizontal-list">
            <li> <Link id="link" to="/signup"> SignUp </Link> </li>
            <li> <Link id="link" to="/product"> Product </Link></li>
            <li> <Link id="link" to="/customer"> Customers </Link></li>
            <li> <Link id="link" to="/login"> Logout </Link></li>
        </ul>
        
        </>
    )
}
export default Home