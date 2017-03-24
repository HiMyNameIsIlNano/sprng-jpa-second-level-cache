import { Address } from './Address';
export interface UserDetails {
  id: number;
  name: string;
  joinDate: Date;
  description: string;
  uselessField: string;
  address: Address;
}
