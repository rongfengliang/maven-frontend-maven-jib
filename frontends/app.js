
import {ClientJS} from 'clientjs';
// Create a new ClientJS object
export default async () => {
  try {
    const client = new ClientJS();
    let response = await fetch("/v1/login");
    let content = await response.text();
    return {
      content,
      fingerPrint:client.getFingerprint()
    };
  } catch (error) {
    console.log(error)
  }
}