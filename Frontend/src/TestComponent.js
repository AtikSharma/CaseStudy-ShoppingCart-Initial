import React from 'react'
import { useState } from 'react';
import  axios  from 'axios';


const TestComponent = () => {

    const [items, setItems] = useState([]);
    const [counter , setCounter] = useState(1);

    const getitems = async (index) => {
        let res = await fetchData();
        setItems(res.data.slice(0,index));
        console.log(res.data.slice(0,index));
      };


    const handleClick = () => {
        setCounter(counter + 1)
      }

  return (
    <div>
        <h1>Team 1</h1>
        <ul>
            <li>
                Harsh Rastogi
            </li>
            <li>
                Jeetu Dwivedi
            </li>
            <li>
                Uday Saraswat
            </li>
            <li>
                Atik Sharma
            </li>
        </ul>
        <ul>
           {items.map((item) => (
               <li key = {item.id}>
                  {item.id} 
                  {item.data} 
                  {item.title} 
                  {item.userId} 
               </li>
           ))
           }
        </ul>

        <div
            className="btn btn-outline-danger rounded  btn-sm m-auto"
            onClick={() => {getitems(counter);
            handleClick()
            }}
          >
              Show More
          </div>
    </div>
  )
}

export default TestComponent

export const fetchData = async () => {
   const res = axios.get(`https://jsonplaceholder.typicode.com/posts`);
   return res;
}



   