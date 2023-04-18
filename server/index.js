const express = require('express')
const mongoose = require('mongoose');
require('dotenv').config();
const app = express();

const port = process.env.PORT;

mongoose.connect(process.env.DB_URL).then(()=> {
    console.log("Database are connected successful!");
}).catch((error) => {
    console.log(error);
})

app.get('/', (req, res) => {
    res.send({
        message:"hello world"
    })
})

app.listen(port,()=>{
    console.log('server are running on port 8001' + " databaseUrl: " + process.env.DB_URL);
})