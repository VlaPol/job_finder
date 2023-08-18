package by.tms.job_finder.service;

import by.tms.job_finder.dto.RegistrationCandidateDto;
import by.tms.job_finder.dto.RegistredCandidateDto;
import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.entity.Cv;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.model.account.CandidatePrincipal;
import by.tms.job_finder.model.token.AccessToken;
import by.tms.job_finder.repository.CandidateRepository;
import by.tms.job_finder.service.auth.AccessTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionOperations;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final AccessTokenService accessTokenService;
    private final PasswordEncoder passwordEncoder;
    private final TransactionOperations txOps;

    @Override
    public Candidate getReferenceById(Long id) {
        return candidateRepository.getReferenceById(id);
    }

    @Override
    public Candidate findById(Long id) throws BusinessException {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Кандидата по указанному id не обнаружено"));
    }

    @Override
    public AccessToken registrateNewCandidate(RegistrationCandidateDto dto) {
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        Candidate candidate = createNewCandidate(dto, passwordHash);
        CandidatePrincipal principal = CandidatePrincipal.from(candidate);
        return accessTokenService.generate(principal);
    }

    @Override
    public AccessToken getTokenForRegisteretCandidate(RegistredCandidateDto entity) {
        return null;
    }

    @Override
    public void remove(Candidate entity) {
        candidateRepository.remove(entity.getId());
    }


    private Candidate createNewCandidate(RegistrationCandidateDto dto, String passwordHash) {
        return txOps.execute(tx -> {
            boolean existsByEmail = candidateRepository.findCandidateByEmail(dto.getEmail()).isPresent();
            if (existsByEmail) {
                throw new BusinessException("Такой пользователь существует");
            }

            Cv cv = new Cv()
                    .setContent(dto.getCandidateCv().getContext());
            Candidate candidate = new Candidate()
                    .setEmail(dto.getEmail())
                    .setPassHash(passwordHash)
                    .setFirstName(dto.getFirstName())
                    .setLastName(dto.getLastName())
                    .setCv(cv);
            candidateRepository.create(candidate);
            return candidate;
        });
    }
}
