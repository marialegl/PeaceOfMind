import { lusitana } from '@/app/ui/fonts';

export default function peaceOfMindLogo() {
  return (
    <div
      className={`${lusitana.className} flex flex-row items-center leading-none text-white`}
    >
      <img src="/Logo.jpg" alt="Acme Logo" className="h-12 w-12" />
      <p className="text-[44px]">Peace Of Mind</p>
    </div>
  );
}
