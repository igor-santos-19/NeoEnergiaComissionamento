import React from 'react';

const ConfirmationModal = ({ message, onConfirm, onCancel }) => {
  return (
    <div className="modal">
      <div className="modal-content">
        <p className='name' >{message}</p>
        <div className="modal-buttons">
          <button className="confirm-btn" onClick={onConfirm}>Confirmar</button>
          <button className="cancel-btn" onClick={onCancel}>Cancelar</button>
        </div>
      </div>
    </div>
  );
};

export default ConfirmationModal;

