import './App.css';
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './components/pages/HomePage';
import NotFound from './components/pages/NotFound';
import LoginPage from './components/pages/LoginPage';
import AdminPage from "./components/pages/AdminPage";
import SignupPage from './components/pages/SignupPage';
import UserPage from './components/pages/UserPage';

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
      </Routes>
    </BrowserRouter>
  );
}

export default App;
