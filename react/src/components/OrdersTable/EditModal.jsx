import React, { useState, useEffect } from 'react';

function EditModal({ show, onClose, onSave, initialData }) {
  const [formData, setFormData] = useState(initialData || {});

  useEffect(() => {
    if (initialData) {
      setFormData(initialData);
    }
  }, [initialData]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Saving data:", formData);
    onSave(formData);
  };

  if (!show) {
    return null;
  }

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <h2>Editar Ordem de Serviço</h2>
        <form onSubmit={handleSubmit}>
          <label>
            Cliente:
            <input type="text" name="cliente" value={formData.cliente || ''} onChange={handleChange} />
          </label>
          <label>
            Protocolo:
            <input type="text" name="protocolo" value={formData.protocolo || ''} onChange={handleChange} />
          </label>
          <label>
            Empresa/Obra:
            <input type="text" name="empresa" value={formData.empresa || ''} onChange={handleChange} />
          </label>
          <label>
            Utep Responsável:
            <input type="text" name="uteperesponsavel" value={formData.uteperesponsavel || ''} onChange={handleChange} />
          </label>
          <label>
            Motivo:
            <input type="text" name="motivo" value={formData.motivo || ''} onChange={handleChange} />
          </label>
          <label>
            Órgão Executor:
            <input type="text" name="orgaoexecutor" value={formData.orgaoexecutor || ''} onChange={handleChange} />
          </label>
          <label>
            Local:
            <select name="localose" value={formData.localose || ''} onChange={handleChange}>
              <option value="">Selecione o local</option>
              <option value="Águas Claras">Águas Claras</option>
              <option value="Arniqueira">Arniqueira</option>
              <option value="Brazlândia">Brazlândia</option>
              {/* adicione todas as outras opções aqui */}
            </select>
          </label>
          <label>
            Data de Abertura:
            <input type="date" name="dataabertura" value={formData.dataabertura || ''} onChange={handleChange} />
          </label>
          <label>
            Data Limite:
            <input type="date" name="datalimite" value={formData.datalimite || ''} onChange={handleChange} />
          </label>
          <button type="submit">Salvar</button>
          <button type="button" onClick={onClose}>Cancelar</button>
        </form>
      </div>
    </div>
  );
}

export default EditModal;
