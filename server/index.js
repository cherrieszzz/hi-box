const express = require('express')
require('dotenv').config();
const app = express();

const port = process.env.PORT;

app.get('/', (req, res) => {
    res.send({
        message:"hello world"
    })
})

app.listen(port,()=>{
    console.log('server are running on port 8001' + " databaseUrl: " + process.env.DB_URL);
})