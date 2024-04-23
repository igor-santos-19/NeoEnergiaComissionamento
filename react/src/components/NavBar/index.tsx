import { Link } from 'react-router-dom'
import logo from '../../assets/neo-energia-logo.png'

const links = [
  {
    name: 'Solicitar Obra',
    path: '/formulario-solicitacao-obra'
  },
  {
    name: 'Ver Ordens Solicitadas',
    path: '/ordens-solicitadas'
  }
]

export function NavBar() {
  return (
    <header className="px-32 py-4 flex justify-between items-center">
      <Link to='/'>
        <img className='h-14' src={logo} alt="Logo Neo Energia" />
      </Link>

      <div className="flex gap-4">
        {
          links && links.map((link, index) => (
            <Link key={index} to={link.path}>
              <span className='font-bold'>{link.name}</span>
            </Link>
          ))
        }
      </div>
    </header>
  )
}