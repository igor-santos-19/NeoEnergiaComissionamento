import { useState, useEffect } from 'react';
import axios from "axios";
import { api } from '../../service/api';

export function OrdersTable() {
  const [orders, setOrders] = useState(0);

  useEffect (()=>{
    loadOsePendente()
  }, []); 

  async  function loadOsePendente() {
    const response = await api.get('/ordemdeservicopendente')
    console.log(response)
  }

  const titles = [
    "Cliente",
    "Protocolo",
    "Empresa/Obra",
    "UTEP",
    "Motivo",
    "Situação",
    "Órgão Executor",
    "Local",
    "Data Abertura",
    "Data Limite",
    "Data Conclusão"
  ];

  return (
    <section className='w-full'>
      <table className='w-full border text-sm'>
        <thead>
          <tr>
            {titles.map((title, index) => (
              <th className='border p-1' key={index}>{title.toUpperCase()}</th>
            ))}
          </tr>
        </thead>

        {/* <tbody>
          {orders.map((item, index) => (
            <tr key={index} className={index % 2 === 0 ? 'bg-slate-200' : ''}>
              <td className='border p-1'>{item.cliente}</td>
              <td className='border p-1'>{item.protocolo}</td>
              <td className='border p-1'>{item.empresaObra}</td>
              <td className='border p-1'>{item.utep}</td>
              <td className='border p-1'>{item.motivo}</td>
              <td className='border p-1'>{item.situacao}</td>
              <td className='border p-1'>{item.orgaoExecutor}</td>
              <td className='border p-1'>{item.local}</td>
              <td className='border p-1'>{item.dataAbertura}</td>
              <td className='border p-1'>{item.dataLimite}</td>
              <td className='border p-1'>{item.dataConclusao}</td>
            </tr>
          ))}
        </tbody> */}
      </table>
    </section>
  );
}
