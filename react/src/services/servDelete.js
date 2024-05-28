import axios from "axios";

export const servDelete = async (url) => {
  try {
    const response = await axios.delete(url);
    return response.data;
  } catch (error) {
    console.error('Erro ao deletar:', error);
    throw error;
  }
};
