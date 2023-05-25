import './App.css';
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './components/pages/HomePage';
import NotFound from './components/pages/NotFound';
import LoginPage from './components/pages/LoginPage';
import AdminPage from "./components/pages/AdminPage";
import SignupPage from './components/pages/SignupPage';
import UserPage from './components/pages/UserPage';
import GoodsPage from './components/pages/GoodsPage';
import GoodsDetailPage from './components/pages/GoodsDetailPage';
import Personalise from './components/pages/Personalise';
import Bigdata from './components/pages/Bigdata';
import Envir from './components/pages/Envir';
import Docs from './components/pages/Docs';
import Partner from './components/pages/Partner';
import About from './components/pages/About';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='*' element={<NotFound />} />
        <Route path='/login' element={<LoginPage />} />
        <Route path='/admin' element={<AdminPage />} />
        <Route path='/sign' element={<SignupPage />} />
        <Route path='/me' element={<UserPage />} />
        <Route path='/goods' element={<GoodsPage />} />
        <Route path='/gooddetail' element={<GoodsDetailPage />} />
        <Route path='/persion' element={<Personalise />} />
        <Route path='/bigdata' element={<Bigdata />} />
        <Route path='/envir' element={<Envir />} />
        <Route path='/docs' element={<Docs />} />
        <Route path='/partner' element={<Partner />} />
        <Route path='/about' element={<About />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
