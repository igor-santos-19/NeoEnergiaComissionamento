import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import axios from "axios";

/** @description Criação de um schema do zod para validações do formulário */
const formRegisterBuildingSchema = z.object({
  client: z.string()
    .min(6, 'O mínimo de caracteres é de 6.')
    .refine(client => {
      return client[0].toUpperCase()
    }),
  company: z.string()
    .min(6, 'O mínimo de caracteres é de 6.'),
  utep: z.string()
    .min(6, 'O mínimo de caracteres é de 6.'),
  reason: z.string(),
  organ: z.string(),
  local: z.string(),
  dateOpening: z.coerce.date(),
  dateLimit: z.coerce.date()
});

type FormRegisterBuildingSchema = z.infer<typeof formRegisterBuildingSchema>

export function FormRegisterBuilding() {
  
  const motivos = ["A Pedido do Cliente"];
  const orgaosEmissores = ["GRAR8", "GRAR", "GRRS"];
  const locais = [
    "Águas Claras",
    "Arniqueira",
    "Brazlândia",
    "Candangolândia",
    "Ceilândia",
    "Cruzeiro",
    "Fercal",
    "Gama",
    "Guará",
    "Itapoã",
    "Jardim Botânico",
    "Lago Norte",
    "Lago Sul",
    "Núcleo Bandeirante",
    "Paranoá",
    "Park Way",
    "Planaltina",
    "Plano Piloto",
    "Recanto das Emas",
    "Riacho Fundo",
    "Riacho Fundo II",
    "Samambaia",
    "Santa Maria",
    "São Sebastião",
    "SCIA",
    "SIA",
    "Sobradinho",
    "Sobradinho II",
    "Sol Nascente/Pôr do Sol",
    "Sudoeste/Octogonal",
    "Taguatinga",
    "Varjão",
    "Vicente Pires"
  ];

  const { 
    register, 
    handleSubmit, 
    formState: { errors } 
  } = useForm<FormRegisterBuildingSchema>({
    resolver: zodResolver(formRegisterBuildingSchema)
  });

  async function handleSubmitBuildingSettings(data: FormRegisterBuildingSchema) {
    // Adicionar logs para depuração
    console.log("Dados do formulário capturados:", data);

    // Formatar as datas
    const formattedData = {
      cliente: data.client,
      empresa: data.company,
      uteperesponsavel: data.utep,
      motivo: data.reason,
      orgaoexecutor: data.organ,
      localose: data.local,
      dataabertura: data.dateOpening.toISOString().split('T')[0],
      datalimite: data.dateLimit.toISOString().split('T')[0]
    };

    console.log("Dados formatados:", formattedData);

    try {
      const response = await axios.post('http://127.0.0.1:8080/ordemdeservicopendente/insereosependente', JSON.stringify(formattedData), {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      console.log('Dados enviados com sucesso:', response.data);
    } catch (error) {
      console.error('Erro ao enviar os dados:', error);
    }
  }

  return (
    <section className="w-full py-14 flex justify-center">
      <div className="p-14 w-5/12 bg-white border-2 rounded-2xl">
        <h3 className="font-bold text-4xl">Solicitação de Obra</h3>

        <p className="mb-9">Solicitar Comissionamento de Obra de Incorporação de Redes.</p>
        
        <form onSubmit={handleSubmit(handleSubmitBuildingSettings)} className="grid grid-cols-2 gap-4">
          <div className="flex flex-col col-span-2">
            <label className="font-bold mb-3" htmlFor="client">Cliente</label>
            <input
              className="p-2 border-2 rounded focus:outline-none focus:border-[--green-medium]"
              type="text"
              placeholder="Ex. Luiz Perez"
              required
              {...register('client')}
            />

            {errors.client && <span className="text-red-600 font-bold text-sm">{errors.client.message}</span>}
          </div>

          <div className="flex flex-col col-span-2">
            <label className="font-bold mb-3" htmlFor="company">Empresa/Obra</label>
            <input
              className="p-2 border-2 rounded focus:outline-none focus:border-[--green-medium]"
              type="text"
              id="company"
              placeholder="Ex. Neoenergia"
              required
              {...register('company')}
            />

            {errors.company && <span className="text-red-600 font-bold text-sm">{errors.company.message}</span>}
          </div>

          <div className="flex flex-col ">
            <label className="font-bold mb-3" htmlFor="utep">Utep Responsável</label>
            <input
              className="p-2 border-2 rounded focus:outline-none focus:border-[--green-medium]"
              type="text"
              id="utep"
              placeholder="UTEP"
              required
              {...register('utep')} 
            />

            {errors.utep && <span className="text-red-600 font-bold text-sm">{errors.utep.message}</span>}
          </div>

          <div className="flex flex-col">
            <label className="font-bold mb-3" htmlFor="reason">Motivo</label>
            <select
              className="p-2 border-2 rounded"
              id="reason"
              required
              {...register('reason')}
            >
              {
                motivos && motivos.map((motivo, index) => (
                  <option key={index} value={motivo}>{motivo}</option>
                ))
              }
            </select>
          </div>

          <div className="flex flex-col">
            <label className="font-bold mb-3" htmlFor="organ">Órgão Emissor</label>
            <select
              className="p-2 border-2 rounded"
              id="organ"
              required
              {...register('organ')}
            >
              {
                orgaosEmissores && orgaosEmissores
                  .sort()
                  .map((orgaoEmissor, index) => (
                    <option key={index} value={orgaoEmissor}>{orgaoEmissor}</option>
                  ))
              }
            </select>
          </div>

          <div className="flex flex-col">
            <label className="font-bold mb-3" htmlFor="local">Local</label>
            <select
              className="p-2 border-2 rounded"
              id="local"
              required
              {...register('local')}
            >
              {
                locais && locais
                  .sort()
                  .map((local, index) => (
                    <option key={index} value={local}>{local}</option>
                  ))
              }
            </select>
          </div>

          <div className="flex flex-col">
            <label className="font-bold mb-3" htmlFor="opening-date">Data de Abertura</label>
            <input
              className="p-2 border-2 rounded focus:outline-none focus:border-[--green-medium]"
              type="date"
              id="dateOpening"
              required
              {...register('dateOpening')}
            />
          </div>

          <div className="flex flex-col">
            <label className="font-bold mb-3" htmlFor="limit-date">Data Limite</label>
            <input
              className="p-2 border-2 rounded focus:outline-none focus:border-[--green-medium]"
              type="date"
              id="dateLimit"
              required
              {...register('dateLimit')}
            />
          </div>

          <input
            className="col-span-2 p-2 border-none rounded cursor-pointer font-bold bg-[--green-light] text-white"
            type="submit"
            value="Enviar"
          />
        </form>
      </div>
    </section>
  )
}
