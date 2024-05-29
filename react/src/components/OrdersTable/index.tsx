import { useState, useEffect } from 'react';
import { api } from '../../service/api';
import { FaRegTrashAlt } from "react-icons/fa";
import { GrEdit } from "react-icons/gr";
import './delete.css';

export function OrdersTable() {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    loadOsePendente();
  }, []);

  async function loadOsePendente() {
    try {
      const response = await api.get('/ordemdeservicopendente/osependente');
      setOrders(response.data);
    } catch (error) {
      console.error('Erro ao carregar as ordens pendentes:', error);
    }
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
    "Fora do Prazo",
    "Dias",
    "Ações",
  ];

  const deleteUser = async (id) => {
    try {
      await api.delete(`/ordemdeservicopendente/${id}`);
      // Atualizar a lista de pedidos após a exclusão
      loadOsePendente();
    } catch (error) {
      console.error('Erro ao excluir pedido:', error);
    }
  }

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

        <tbody>
          {orders.map((item, index) => (
            <tr key={index} className={index % 2 === 0 ? 'bg-slate-200' : ''}>
              <td className='border p-1'>{item.cliente}</td>
              <td className='border p-1'>{item.protocolo}</td>
              <td className='border p-1'>{item.empresa}</td>
              <td className='border p-1'>{item.uteperesponsavel}</td>
              <td className='border p-1'>{item.motivo}</td>
              <td className='border p-1'>{item.situacao}</td>
              <td className='border p-1'>{item.orgaoexecutor}</td>
              <td className='border p-1'>{item.localose}</td>
              <td className='border p-1'>{item.dataabertura}</td>
              <td className='border p-1'>{item.datalimite}</td>
              <td className='border p-1'>{item.foradoprazo}</td>
              <td className='border p-1'>{item.dias}</td>
              <td className='border p-1'>
                <button type='button' onClick={() => deleteUser(item.id)} className='excluir'>
                  <FaRegTrashAlt />
                </button>
                <button type='button' className='editar'>
                  <GrEdit />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
}
