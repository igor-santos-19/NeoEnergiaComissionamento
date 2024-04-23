import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'

import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import { FormPage } from './routes/form-page.tsx'
import { HomePage } from './routes/home-page.tsx'
import { OrderPage } from './routes/orders-page.tsx'

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: [
      {
        path: '/',
        element: <HomePage />
      },
      {
        path: '/formulario-solicitacao-obra',
        element: <FormPage />
      },
      {
        path: '/ordens-solicitadas',
        element: <OrderPage />
      }
    ]
  }
])

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router}/>
  </React.StrictMode>
)
